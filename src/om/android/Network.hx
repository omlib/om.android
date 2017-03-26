package om.android;

@:require(js,android)
@:native("om_Network")
extern class Network {
    static function isAvailable() : Bool;
    static function isWifiActive() : Bool;
}
