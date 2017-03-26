package om.android;

@:require(js,android)
@:native("om_SystemUi")
extern class SystemUi {

    public static inline var FULLSCREEN = 0x00000004;
    public static inline var HIDE_NAVIGATION = 0x00000002;
    public static inline var IMMERSIVE = 0x00000800;
    public static inline var IMMERSIVE_STICKY = 0x00001000;
    public static inline var LAYOUT_FULLSCREEN = 0x00000400;
    public static inline var LAYOUT_HIDE_NAVIGATION = 0x00000200;
    public static inline var LAYOUT_STABLE = 0x00000100;
    public static inline var LOW_PROFILE = 0x00000001;
    public static inline var VISIBLE = 0x00000000;

    static function setFlag( flag : Int ) : Void;
    static function setPermanentFlag( flag : Int ) : Void;

    //static function addFlag( flag : Int ) : Void;
    //static function removeFlag( flag : Int ) : Void;
    //static function apply() : Void;

    //static function showNavigationControls() : Void;
    //static function hideNavigationControls() : Void;

}
