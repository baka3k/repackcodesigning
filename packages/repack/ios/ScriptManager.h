#ifdef RCT_NEW_ARCH_ENABLED
#import "RNScriptManagerSpec.h"

@interface ScriptManager : NSObject <NativeScriptManagerSpec>
@property (nonatomic, strong) NSString *publicKey;
- (instancetype)initWithPublicKey:(NSString *)publicKey;
#else
#import <React/RCTBridgeModule.h>

@interface ScriptManager : NSObject <RCTBridgeModule>
@property (nonatomic, strong) NSString *publicKey;
- (instancetype)initWithPublicKey:(NSString *)publicKey;
#endif

@end
