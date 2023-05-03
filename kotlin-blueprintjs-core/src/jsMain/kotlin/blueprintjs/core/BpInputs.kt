@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithClassName
import react.ReactElement
import react.Ref
import react.State
import web.html.HTMLInputElement

@Deprecated("Deprecated in TypeScript", ReplaceWith("InputGroupProps2"))
external interface InputGroupProps : IControlledProps, IntentProps, PropsWithClassName {
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
    var inputRef: Ref<HTMLInputElement>?

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
     * Whether the input is read-only.
     *
     * Note that `rightElement` must be disabled or made read-only separately;
     * this prop will not affect it.
     *
     * @default false
     */
    var readOnly: Boolean?

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

/**
 * Shared props interface for text & numeric inputs.
 */
external interface InputSharedProps : IntentProps, PropsWithClassName {
    /**
     * Whether the input is non-interactive.
     *
     * Note that the content in `rightElement` must be disabled separately if defined;
     * this prop will not affect it.
     *
     * @default false
     */
    var disabled: Boolean?
    /**
     * Whether the component should take up the full width of its container.
     */
    var fill: Boolean?
    /**
     * Class name to apply to the `<input>` element (not the InputGroup container).
     */
    var inputClassName: String?
    /**
     * Ref attached to the HTML `<input>` element backing this component.
     */
    var inputRef: Ref<HTMLInputElement>?
    /**
     * Element to render on the left side of input.
     * This prop is mutually exclusive with `leftIcon`.
     */
    var leftElement: ReactElement<*>?
    /**
     * Name of a Blueprint UI icon to render on the left side of the input group,
     * before the user's cursor.
     *
     * This prop is mutually exclusive with `leftElement`.
     *
     * Note: setting a JSX.Element here is deprecated; use the `leftElement` prop instead.
     */
    var leftIcon: dynamic // IconName | MaybeElement | null
    /**
     * Placeholder text in the absence of any value.
     */
    var placeholder: String?
    /**
     * Element to render on right side of input.
     * For best results, use a minimal button, tag, or small spinner.
     */
    var rightElement: ReactElement<*>?
}

external interface InputGroupProps2 : HTMLInputProps, ControlledProps2, InputSharedProps {
    /**
     * Set this to `true` if you will be controlling the `value` of this input with asynchronous updates.
     * These may occur if you do not immediately call setState in a parent component with the value from
     * the `onChange` handler, or if working with certain libraries like __redux-form__.
     *
     * @default false
     */
    var asyncControl: Boolean?

    /** Whether this input should use large styles. */
    var large: Boolean?

    /** Whether this input should use small styles. */
    var small: Boolean?

    /** Whether the input (and any buttons) should appear with rounded caps. */
    var round: Boolean?

    /**
     * Name of the HTML tag that contains the input group.
     *
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements
}

external interface IInputGroupState : State {
    var leftElementWidth: Int?
    var rightElementWidth: Int?
}

external class InputGroup : AbstractPureComponent2<InputGroupProps2, IInputGroupState> {
    override fun render(): ReactElement<InputGroupProps2>
}
