import SwiftUI
import Shared

struct ExploreView: View {
    @StateObject private var viewModel = ExploreViewModelIos()

    var body: some View {
        Group {
            if viewModel.state.isLoading {
                ProgressView()
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
            } else if let error = viewModel.state.error {
                Text("Error: \(error)")
                    .foregroundColor(.red)
                    .multilineTextAlignment(.center)
                    .padding()
            } else {
                SuccessExploreScreen(users: viewModel.state.users)
            }
        }
        .onAppear {
            viewModel.load()
        }
    }
}

struct SuccessExploreScreen: View {
    let users: [UserVo]

    var body: some View {
        ScrollView {
            LazyVStack(spacing: 16) {
                ForEach(users, id: \.email) { user in
                    UserItem(user: user) {}
                }
            }
            .padding(.top, 32)
        }
        .frame(maxWidth: .infinity)
    }
}


struct UserItem: View {
    let user: UserVo
    let onItemClick: () -> Void

    var body: some View {
        VStack(spacing: 0) {
            UserContactRow(user: user)
            Divider()
                .padding(.top, 16)
                .padding(.leading, 64)
        }
        .padding(.leading, 16)
        .contentShape(Rectangle())
        .onTapGesture(perform: onItemClick)
    }
}

struct UserContactRow: View {
    let user: UserVo

    var body: some View {
        HStack {
            Image(systemName: "person.crop.circle")
                .resizable()
                .frame(width: 64, height: 64)
            ContentRow(user: user)
        }
    }
}

struct ContentRow: View {
    let user: UserVo

    var body: some View {
        HStack {
            VStack(alignment: .leading, spacing: 4) {
                Text("Nombre: \(user.name)")
                    .font(.body)
                Text("Email: \(user.email)")
                    .font(.body)
            }
            Spacer()
        }
        .padding(16)
        .frame(height: 32)
    }
}
