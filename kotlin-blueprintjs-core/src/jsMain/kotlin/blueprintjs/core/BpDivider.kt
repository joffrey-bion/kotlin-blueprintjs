@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external interface IDividerProps : PropsWithClassName, PropsWithChildren {
    /**
     * HTML tag to use for element.
     *
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements
}

/**
 * Divider component.
 *
 * https://blueprintjs.com/docs/#core/components/divider
 */
open external class Divider : AbstractPureComponent2<IDividerProps, State> {
    override fun render(): ReactElement<IDividerProps>
}
