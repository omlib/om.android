package om.android;

@:require(js,android)
@:native("om_App")
extern class App {
    static function quit() : Int;
}
