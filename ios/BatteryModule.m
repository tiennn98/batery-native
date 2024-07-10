//
//  BatteryModule.m
//  battery
//
//  Created by tiennn on 10/7/24.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(BatteryModule, NSObject)
RCT_EXTERN_METHOD(getDeviceBatteryLevel:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
@end
