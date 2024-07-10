//
//  BatteryModule.swift
//  battery
//
//  Created by tiennn on 10/7/24.
//

import Foundation
import UIKit

@objc(BatteryModule)
class BatteryModule: NSObject {
  
  @objc
  func getDeviceBatteryLevel(_ resolve: @escaping RCTPromiseResolveBlock, reject: @escaping RCTPromiseRejectBlock) {
    UIDevice.current.isBatteryMonitoringEnabled = true
    let batteryLevel = UIDevice.current.batteryLevel
    if batteryLevel >= 0 {
      resolve(Int(batteryLevel * 100))
    } else {
      let error = NSError(domain: "", code: 200, userInfo: nil)
      reject("no_battery_info", "Unable to get battery info2222", error)
    }
  }
  
  @objc
  static func requiresMainQueueSetup() -> Bool {
    return true
  }
}
