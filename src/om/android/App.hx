package om.android;

@:native("om_App")
@:require(js,android)
extern class App {
    static function quit() : Int;
}
