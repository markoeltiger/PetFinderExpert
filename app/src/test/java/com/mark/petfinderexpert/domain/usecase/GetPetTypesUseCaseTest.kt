package com.mark.petfinderexpert.domain.usecase

import app.cash.turbine.test
import com.mark.petfinderexpert.MainCoroutineRule
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.domain.repos.PetsRepo
import com.mark.petfinderexpert.utils.network.Resource
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.spy
import org.mockito.kotlin.whenever

class GetPetTypesUseCaseTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private var closeableMockito: AutoCloseable? = null

    @Mock
    private lateinit var petsRepo: PetsRepo
    private lateinit var getPetsTypesUseCase: GetPetTypesUseCase


    @Before
    fun beforeEach() {
        closeableMockito = MockitoAnnotations.openMocks(this)
          getPetsTypesUseCase = spy(GetPetTypesUseCase(petsRepo))
    }

    @Test
    fun `GetPetsTypesUseCase should return error when request fails`() =
        runTest {
            val error = Resource.Error<PetTypesResponse>("InternetNet Error")

            whenever(petsRepo.getPetTypes()).doReturn(flowOf(error))

            getPetsTypesUseCase.test {
                awaitItem() shouldBeEqualTo error
                awaitComplete()
            }

        }
    @Test
    fun `GetPetTypesUseCase should return types list when request is successful`() =
        runTest {
            val petsTypes = PetTypesResponse(emptyList())
            whenever(petsRepo.getPetTypes()).doReturn(
                flowOf(
                    Resource.Success(
                        petsTypes
                    )
                )
            )
            getPetsTypesUseCase.test {
                awaitItem() shouldBeEqualTo Resource.Success(petsTypes)
                awaitComplete()
            }
        }

    @After
    @Throws(Exception::class)
    fun afterEach() {
        closeableMockito?.close()

    }
}