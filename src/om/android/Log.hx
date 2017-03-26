package om.android;

@:require(js,android)
@:native("om_Log")
extern class Log {

    static function debug( msg : String ) : Void;
    static function error( msg : String ) : Void;
    static function info( msg : String ) : Void;
    static function verbose( msg : String ) : Void;
    static function warn( msg : String ) : Void;

    @:native("debug")
    static function d( msg : String ) : Void;

    @:native("error")
    static function e( msg : String ) : Void;

    @:native("info")
    static function i( msg : String ) : Void;

    @:native("verbose")
    static function v( msg : String ) : Void;

    @:native("warn")
    static function w( msg : String ) : Void;

    static function wtf( msg : String ) : Void;

}
