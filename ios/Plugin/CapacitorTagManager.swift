import Foundation

import NetworkExtension
import SystemConfiguration.CaptiveNetwork
import CoreLocation

public typealias PluginResultData = [String: Any]

@objc public class CapacitorTagManager: NSObject, CLLocationManagerDelegate {

    
    public func logEvent(call: CAPPluginCall) -> Void {
    }
}
