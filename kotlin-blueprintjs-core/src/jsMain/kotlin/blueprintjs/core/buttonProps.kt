@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.html.*
import web.html.*

external interface ButtonSharedProps<T : HTMLElement> : ActionProps<T> {

    // artificially added to allow title on button (should probably be on more general props)
    var title: String?

    /**
     * If set to `true`, the button will display in an active state.
     * This is equivalent to setting `className={Classes.ACTIVE}`.
     * @default false
     */
    var active: Boolean?

    /**
     * Text alignment within button. By default, icons and text will be centered
     * within the button. Passing `"left"` or `"right"` will align the button
     * text to that side and push `icon` and `rightIcon` to either edge. Passing
     * `"center"` will center the text and icons together.
     * @default Alignment.CENTER
     */
    var alignText: Alignment?

    /** Whether this button should expand to fill its container. */
    var fill: Boolean?

    /** Whether this button should use large styles. */
    var large: Boolean?

    /**
     * If set to `true`, the button will display a centered loading spinner instead of its contents.
     * The width of the button is not affected by the value of this prop.
     * @default false
     */
    var loading: Boolean?

    /** Whether this button should use minimal styles. */
    var minimal: Boolean?

    /** Whether this button should use outlined styles. */
    var outlined: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render after the text. */
    var rightIcon: dynamic /* IconName | MaybeElement */

    /** Whether this button should use small styles. */
    var small: Boolean?

    // 'type' is already in different HTMLAttributes subclasses with a different types,
    // so we can't really declare it here with a general type.
}

/**
 * Props interface assignable to both the Button and AnchorButton components.
 *
 * It is useful for the props for the two components to be assignable to each other because the components
 * are so similar and distinguishing between them in their event handlers is usually unnecessary.
 */
external interface ButtonSharedPropsAndAttributes : ButtonSharedProps<HTMLElement>, HTMLAttributes<HTMLElement>
external interface ButtonProps : ButtonSharedProps<HTMLButtonElement>, ButtonHTMLAttributes<HTMLButtonElement>, PropsWithRef<HTMLButtonElement>
external interface AnchorButtonProps : ButtonSharedProps<HTMLAnchorElement>, AnchorHTMLAttributes<HTMLAnchorElement>, PropsWithRef<HTMLAnchorElement>
