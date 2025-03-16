import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        SharedMain.initialize()
    }
    
    var body: some Scene {
        WindowGroup {
            AuthStateView()
        }
    }
}
