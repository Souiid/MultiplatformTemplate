import SwiftUI
import GoogleMaps

@main
struct iOSApp: App {
    
    init() {
        if let apiKey = Bundle.main.object(forInfoDictionaryKey: "MAPS_API_KEY") as? String {
            GMSServices.provideAPIKey(apiKey)
        }
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
