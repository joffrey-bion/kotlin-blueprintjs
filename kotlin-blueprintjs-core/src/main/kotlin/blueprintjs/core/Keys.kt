@file:JsModule("@blueprintjs/core")

package blueprintjs.core

external class Keys {
    companion object {
        val BACKSPACE: String = definedExternally
        val TAB: String = definedExternally
        val ENTER: String = definedExternally
        val SHIFT: String = definedExternally
        val ESCAPE: String = definedExternally
        val SPACE: String = definedExternally
        val ARROW_LEFT: String = definedExternally
        val ARROW_UP: String = definedExternally
        val ARROW_RIGHT: String = definedExternally
        val ARROW_DOWN: String = definedExternally
        val DELETE: String = definedExternally

        fun isKeyboardClick(keyCode: Int): Boolean
    }
}
