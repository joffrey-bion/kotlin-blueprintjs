@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.MouseEvent
import react.dom.html.*
import web.html.*

external interface TagProps : PropsWithClassName, IntentProps, TagSharedProps, PropsWithRef<HTMLSpanElement>,
    HTMLAttributes<HTMLSpanElement>, PropsWithChildren {

    // 'children' is declared via PropsWithChildren

    /**
     * HTML title to be passed to the <Text> component
     */
    var htmlTitle: String?

    /**
     * Name of a Blueprint UI icon (or an icon element) to render on the left side of the tag,
     * before the child nodes.
     */
    override var icon: Any? // IconName? | MaybeElement?

    /**
     * Whether tag content should be allowed to occupy multiple lines.
     * If false, a single line of text will be truncated with an ellipsis if
     * it overflows. Note that icons will be vertically centered relative to
     * multiline text.
     * @default false
     */
    var multiline: Boolean?

    /**
     * Click handler for remove button.
     * The remove button will only be rendered if this prop is defined.
     */
    var onRemove: ((e: MouseEvent<HTMLButtonElement, *>, tagProps: TagProps) -> Unit)?
}

/**
 * Tag component.
 *
 * https://blueprintjs.com/docs/#core/components/tag
 */
external val Tag : FC<TagProps>
