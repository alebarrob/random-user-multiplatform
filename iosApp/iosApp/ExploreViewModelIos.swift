import SwiftUI
import Shared

@MainActor
class ExploreViewModelIos: ObservableObject {
    @Published var state = ExploreState(
        isLoading: false,
        users: [],
        error: nil
    )
    
    private let viewModel: ExploreViewModel

    init() {
        viewModel = KoinHelpers.shared.provideExploreViewModel()
        
        viewModel.subscribe { newState in
            Task { @MainActor in
                self.state = newState
            }
        }
    }
    
    func load() {
        viewModel.load()
    }
    
    deinit {
        viewModel.clear()
    }
}
