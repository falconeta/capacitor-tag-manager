import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CapacitorTagManagerPlugin)
public class CapacitorTagManagerPlugin: CAPPlugin {
    private let implementation = CapacitorTagManager()

    @objc func logEvent(_ call: CAPPluginCall) {
        implementation.logEvent(cal: call);
    }
}
