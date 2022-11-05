@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLInputElement
import react.State
import react.ReactElement

@Deprecated("Deprecated in TypeScript", ReplaceWith("InputGroupProps2"))
external interface IInputGroupProps : IControlledProps, IIntentProps, IProps {
    /**
     * Set this to `true` if you will be controlling the `value` of this input with asynchronous updates.
     * These may occur if you do not immediately call setState in a parent component with the value from
     * the `onChange` handler, or if working with certain libraries like __redux-form__.
     *
     * @default false
     */
    var asyncControl: Boolean?

    /**
     * Whether the input is non-interactive.
     * Note that `rightElement` must be disabled separately; this prop will not affect it.
     *
     * @default false
     */
    var disabled: Boolean?

    /**
     * Whether the component should take up the full width of its container.
     */
    var fill: Boolean?

    /** Ref handler or a ref object that receives HTML `<input>` element backing this component. */
    var inputRef: ((ref: HTMLInputElement?) -> Any)?

    /**
     * Element to render on the left side of input.  This prop is mutually exclusive
     * with `leftIcon`.
     */
    var leftElement: ReactElement<*>?

    /**
     * Name of a Blueprint UI icon to render on the left side of the input group,
     * before the user's cursor.  This prop is mutually exclusive with `leftElement`.
     * Usage with content is deprecated.  Use `leftElement` for elements.
     */
    var leftIcon: dynamic /* IconName | MaybeElement */

    /** Whether this input should use large styles. */
    var large: Boolean?

    /** Whether this input should use small styles. */
    var small: Boolean?

    /** Placeholder text in the absence of any value. */
    var placeholder: String?

    /**
     * Element to render on right side of input.
     * For best results, use a minimal button, tag, or small spinner.
     */
    var rightElement: ReactElement<*>?

    /** Whether the input (and any buttons) should appear with rounded caps. */
    var round: Boolean?

    /**
     * HTML `input` type attribute.
     * @default "text"
     */
    var type: String?
}

external interface IInputGroupProps2 : HTMLInputProps, IControlledProps2, IIntentProps, IProps {
    /**
     * Set this to `true` if you will be controlling the `value` of this input with asynchronous updates.
     * These may occur if you do not immediately call setState in a parent component with the value from
     * the `onChange` handler, or if working with certain libraries like __redux-form__.
     *
     * @default false
     */
    var asyncControl: Boolean?

    /**
     * Whether the input is non-interactive.
     * Note that `rightElement` must be disabled separately; this prop will not affect it.
     *
     * @default false
     */
    var disabled: Boolean?

    /**
     * Whether the component should take up the full width of its container.
     */
    var fill: Boolean?

    /** Ref handler or a ref object that receives HTML `<input>` element backing this component. */
    var inputRef: ((ref: HTMLInputElement?) -> Any)?

    /**
     * Element to render on the left side of input.  This prop is mutually exclusive
     * with `leftIcon`.
     */
    var leftElement: ReactElement<*>?

    /**
     * Name of a Blueprint UI icon to render on the left side of the input group,
     * before the user's cursor.  This prop is mutually exclusive with `leftElement`.
     * Usage with content is deprecated.  Use `leftElement` for elements.
     */
    var leftIcon: dynamic /* IconName | MaybeElement */

    /** Whether this input should use large styles. */
    var large: Boolean?

    /** Whether this input should use small styles. */
    var small: Boolean?

    /** Placeholder text in the absence of any value. */
    var placeholder: String?

    /**
     * Element to render on right side of input.
     * For best results, use a minimal button, tag, or small spinner.
     */
    var rightElement: ReactElement<*>?

    /** Whether the input (and any buttons) should appear with rounded caps. */
    var round: Boolean?

    /**
     * HTML `input` type attribute.
     * @default "text"
     */
    var type: String?
}

external interface IInputGroupState : State {
    var leftElementWidth: Int
    var rightElementWidth: Int
}

external class InputGroup : AbstractPureComponent2<IInputGroupProps2, IInputGroupState> {
    override fun render(): ReactElement<IInputGroupProps2>
}
