@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.html.*
import web.html.*

external object SpinnerSize {
    val SMALL: Int = definedExternally
    val STANDARD: Int = definedExternally
    val LARGE: Int = definedExternally
}

external interface SpinnerProps<T : HTMLElement> : PropsWithClassName, IntentProps, HTMLAttributes<T> {
    /**
     * Width and height of the spinner in pixels. The size cannot be less than
     * 10px.
     *
     * Constants are available for common sizes:
     * - `Spinner.SIZE_SMALL = 20px`
     * - `Spinner.SIZE_STANDARD = 50px`
     * - `Spinner.SIZE_LARGE = 100px`
     *
     * @default Spinner.SIZE_STANDARD = 50
     */
    var size: Int?
    /**
     * HTML tag for the two wrapper elements. If rendering a `<Spinner>` inside
     * an `<svg>`, change this to an SVG element like `"g"`.
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements
    /**
     * A value between 0 and 1 (inclusive) representing how far along the operation is.
     * Values below 0 or above 1 will be interpreted as 0 or 1 respectively.
     * Omitting this prop will result in an "indeterminate" spinner where the head spins indefinitely.
     */
    var value: Double?
}

/**
 * Spinner component.
 *
 * https://blueprintjs.com/docs/#core/components/spinner
 */
external class Spinner : AbstractPureComponent<SpinnerProps<HTMLElement>, State> {
    override fun render(): ReactElement<*>
}
