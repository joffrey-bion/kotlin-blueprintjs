@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import org.w3c.dom.events.MouseEvent
import react.RProps

/**
 * Alias for all valid HTML props for `<div>` element.
 * Does not include React's `ref` or `key`.
 */
// React.HTMLAttributes<HTMLDivElement>
external interface HTMLDivProps {

    // TODO add more attributes as needed
}

/**
 * Alias for all valid HTML props for `<input>` element.
 * Does not include React's `ref` or `key`.
 */
// React.InputHTMLAttributes<HTMLInputElement>
external interface HTMLInputProps {

    /** Change event handler. Use `event.target.value` for new value. */
    var onChange: ((Event) -> Unit)?

    // TODO add more attributes as needed
}

// MaybeElement in typealiases

/**
 * A shared base interface for all Blueprint component props.
 */
external interface IProps : RProps {
    /** A space-delimited list of class names to pass along to a child element. */
    var className: String?
}

external interface IIntentProps {
    /** Visual intent color to apply to element. */
    var intent: Intent?
}

/**
 * Interface for a clickable action, such as a button or menu item.
 * These props can be spready directly to a `<Button>` or `<MenuItem>` element.
 */
external interface IActionProps : IIntentProps, IProps {
    /** Whether this action is non-interactive. */
    var disabled: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render before the text. */
    var icon: IconName?

    /** Click event handler. */
    var onClick: ((event: MouseEvent) -> Unit)?

    /** Action text. Can be any single React renderable. */
    var text: String?
}

/** Interface for a link, with support for customizing target window. */
external interface ILinkProps {
    /** Link URL. */
    var href: String?

    /** Link target attribute. Use `"_blank"` to open in a new window. */
    var target: String?
}

/** Interface for a controlled input. */
@Deprecated("Use IControlledProps2", ReplaceWith("IControlledProps2"))
external interface IControlledProps {
    /** Initial value of the input, for uncontrolled usage. */
    var defaultValue: String?

    /** Change event handler. Use `event.target.value` for new value. */
    var onChange: ((Event) -> Unit)?

    /** Form value of the input, for controlled usage. */
    var value: String?
}

/** Interface for a controlled input. */
external interface IControlledProps2 {
    /** Initial value of the input, for uncontrolled usage. */
    var defaultValue: String?

    /** Form value of the input, for controlled usage. */
    var value: String?
}

external interface IElementRefProps<E : HTMLElement> {
    /** A ref handler or a ref object that receives the native HTML element rendered by this component. */
    var elementRef: IRef<E>
}

/**
 * An interface for an option in a list, such as in a `<select>` or `RadioGroup`.
 * These props can be spread directly to an `<option>` or `<Radio>` element.
 */
external interface IOptionProps : IProps {
    /** Whether this option is non-interactive. */
    var disabled: Boolean?

    /** Label text for this option. If omitted, `value` is used as the label. */
    var label: String?

    /** Value of this option. */
    var value: Any? // String | Number
}

// TODO fun removeNonHTMLProps