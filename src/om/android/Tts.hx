package om.android;

@:require(js,android)
@:native("om_Tts")
extern class Tts {
    static function setLanguage( lang : String ) : Bool;
    static function setPitch( v : Float ) : Void;
    static function setSpeechRate( v : Float ) : Void;
    static function speak( text : String ) : Void;
    static function stop() : Void;
    static function shutdown() : Void;
}
