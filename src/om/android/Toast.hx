package om.android;

@:require(js,android)
@:native("om_Toast")
extern class Toast {
    static function show( msg : String ) : Void;
}
