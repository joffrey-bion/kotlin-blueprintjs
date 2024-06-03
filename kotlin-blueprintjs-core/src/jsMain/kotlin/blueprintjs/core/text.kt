@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.html.*
import web.html.*

external interface TextProps : PropsWithClassName, PropsWithRef<HTMLElement>, HTMLAttributes<HTMLElement>,
    PropsWithChildren {

    // 'children' is declared via PropsWithChildren

    /**
     * Indicates that this component should be truncated with an ellipsis if it overflows its container.
     * The `title` attribute will also be added when content overflows to show the full text of the children on hover.
     *
     * @default false
     */
    var ellipsize: Boolean?

    /**
     * HTML tag name to use for rendered element.
     *
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements

    /**
     * HTML title of the element
     */
    override var title: String?
}

external val Text : FC<TextProps>
