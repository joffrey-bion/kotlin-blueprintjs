@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.*
import web.html.*
import web.window.*
import kotlin.js.Json

external val DISPLAYNAME_PREFIX: String

// NOTE: the following types are declared in props.nonexternals.kt instead (because typealiases are not external)
//
// HTMLDivProps
// HTMLInputProps
// MaybeElement

external interface IntentProps {
    /** Visual intent color to apply to element. */
    var intent: Intent?
}

/**
 * Interface for a clickable action, such as a button or menu item.
 * These props can be spready directly to a `<Button>` or `<MenuItem>` element.
 */
external interface ActionProps<T : HTMLElement> : IntentProps, PropsWithClassName {
    /** Whether this action is non-interactive. */
    var disabled: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render before the text. */
    var icon: IconName? // IconName | MaybeElement

    /** Click event handler. */
    var onClick: MouseEventHandler<T>?

    /** Focus event handler. */
    var onFocus: FocusEventHandler<T>?

    /** Action text. Can be any single React renderable. */
    var text: ReactNode?
}

/** Interface for a link, with support for customizing target window. */
external interface LinkProps {
    /** Link URL. */
    var href: String?

    /** Link target attribute. Use `"_blank"` to open in a new window. */
    var target: WindowTarget? // type of HTMLAnchorElement.target (for React.HTMLAttributeAnchorTarget)
}

/**
 * Interface for a controlled or uncontrolled component, typically a form control.
 */
external interface ControlledValueProps<T, E : HTMLElement> {
    /**
     * Initial value for uncontrolled usage. Mutually exclusive with `value` prop.
     */
    var defaultValue: T?
    /**
     * Controlled value. Mutually exclusive with `defaultValue` prop.
     */
    var value: T?
    /**
     * Callback invoked when the component value changes, typically via user interaction, in both controlled and
     * uncontrolled mode.
     *
     * Using this prop instead of `onChange` can help avoid common bugs in React 16 related to Event Pooling
     * where developers forget to save the text value from a change event or call `event.persist()`.
     *
     * https://legacy.reactjs.org/docs/legacy-event-pooling.html
     */
    var onValueChange: ((value: T, targetElement: E?) -> Unit)?
}

@Deprecated(level = DeprecationLevel.ERROR, message = "check props.kt")
external interface ControlledProps : ControlledValueProps<String, HTMLInputElement>

/**
 * An interface for an option in a list, such as in a `<select>` or `RadioGroup`.
 * These props can be spread directly to an `<option>` or `<Radio>` element.
 */
external interface OptionProps<T /* string | number */> : PropsWithClassName {
    /** Whether this option is non-interactive. */
    var disabled: Boolean?

    /** Label text for this option. If omitted, `value` is used as the label. */
    var label: String?

    /** Value of this option (string or number). */
    var value: T
}

/**
 * Typically applied to HTMLElements to filter out disallowed props. When applied to a Component,
 * can filter props from being passed down to the children. Can also filter by a combined list of
 * supplied prop keys and the denylist (only appropriate for HTMLElements).
 *
 * @param props The original props object to filter down.
 * @param {string[]} invalidProps If supplied, overwrites the default denylist.
 * @param {boolean} shouldMerge If true, will merge supplied invalidProps and denylist together.
 */
external fun removeNonHTMLProps(
    props: Json,
    invalidProps: Array<String>? = definedExternally,
    shouldMerge: Boolean? = definedExternally,
): Json
