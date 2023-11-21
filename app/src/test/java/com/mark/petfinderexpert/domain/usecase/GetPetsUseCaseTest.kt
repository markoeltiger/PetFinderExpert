package com.mark.petfinderexpert.domain.usecase

import app.cash.turbine.test
import com.mark.petfinderexpert.MainCoroutineRule
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import com.mark.petfinderexpert.domain.repos.PetsRepo
import com.mark.petfinderexpert.utils.network.Resource
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.spy
import org.mockito.kotlin.whenever

class GetPetsUseCaseTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private var closeableMockito: AutoCloseable? = null

    @Mock
    private lateinit var petsRepo: PetsRepo
    private lateinit var getPetsUseCase: GetPetsUseCase


    @Before
    fun beforeEach() {
        closeableMockito = MockitoAnnotations.openMocks(this)
        getPetsUseCase = spy(GetPetsUseCase(petsRepo))
    }

    @org.junit.Test
    fun `GetPetUseCase should return types list when request is successful`() =
        runTest {
            val petsTypes = PetTypesResponse(emptyList())
            whenever(petsRepo.getPets(anyString())).doReturn(
                flowOf(
                    Resource.Success(
                        PetsResponse(emptyList(),null)
                    )
                )
            )
            getPetsUseCase.test {
                awaitItem() shouldBeEqualTo Resource.Success(petsTypes)
                awaitComplete()
            }
        }
    @Test
    fun getPets() {
    }
}