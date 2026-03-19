package fr.eseo.seriestracker.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.eseo.seriestracker.model.TvShow
import fr.eseo.seriestracker.repository.SeriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PopulairesUiState(
    val series: List<TvShow> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class PopulairesViewModel @Inject constructor(
    private val repository: SeriesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PopulairesUiState())
    val uiState: StateFlow<PopulairesUiState> = _uiState.asStateFlow()

    init {
        chargerSeries()
    }

    fun chargerSeries() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            val result = repository.getPopulaires()
            if (result.isSuccess) {
                _uiState.update { it.copy(series = result.getOrDefault(emptyList()), isLoading = false) }
            } else {
                _uiState.update { it.copy(isLoading = false, error = result.exceptionOrNull()?.localizedMessage ?: "Erreur inconnue") }
            }
        }
    }

    fun reessayer() {
        chargerSeries()
    }
}