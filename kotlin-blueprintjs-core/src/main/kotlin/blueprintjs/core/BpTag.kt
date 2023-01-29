@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithChildren
import react.PropsWithClassName
import react.ReactElement
import react.State
import react.dom.events.MouseEvent
import web.html.HTMLButtonElement
import web.html.HTMLDivElement

external interface TagProps : PropsWithClassName, PropsWithChildren, IntentProps {
    /**
     * Whether the tag should appear in an active state.
     * @default false
     */
    var active: Boolean?

    /**
     * Whether the tag should take up the full width of its container.
     * @default false
     */
    var fill: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render before the children. */
    var icon: Any? // IconName? | MaybeElement?

    /**
     * Whether the tag should visually respond to user interactions. If set
     * to `true`, hovering over the tag will change its color and mouse cursor.
     *
     * Recommended when `onClick` is also defined.
     *
     * @default false
     */
    var interactive: Boolean?

    /**
     * Whether this tag should use large styles.
     * @default false
     */
    var large: Boolean?

    /**
     * Whether this tag should use minimal styles.
     * @default false
     */
    var minimal: Boolean?

    /**
     * Whether tag content should be allowed to occupy multiple lines.
     * If false, a single line of text will be truncated with an ellipsis if
     * it overflows. Note that icons will be vertically centered relative to
     * multiline text.
     * @default false
     */
    var multiline: Boolean?

    /**
     * Callback invoked when the tag is clicked.
     * Recommended when `interactive` is `true`.
     */
    var onClick: ((e: MouseEvent<HTMLDivElement, *>) -> Unit)?

    /**
     * Click handler for remove button.
     * The remove button will only be rendered if this prop is defined.
     */
    var onRemove: ((e: MouseEvent<HTMLButtonElement, *>, tagProps: TagProps) -> Unit)?

    /** Name of a Blueprint UI icon (or an icon element) to render after the children. */
    var rightIcon: Any? // IconName? | MaybeElement?

    /**
     * Whether this tag should have rounded ends.
     * @default false
     */
    var round: Boolean?

    /**
     * HTML title to be passed to the <Text> component
     */
    var htmlTitle: String?
}

/**
 * Tag component.
 *
 * https://blueprintjs.com/docs/#core/components/tag
 */
external class Tag : AbstractPureComponent2<TagProps, State> {
    override fun render(): ReactElement<TagProps>
}
