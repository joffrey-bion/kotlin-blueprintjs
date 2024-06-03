@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import web.html.*

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
}
