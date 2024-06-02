@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.*
import web.cssom.*
import web.html.*
import kotlin.js.Json

external val DISPLAYNAME_PREFIX: String

/**
 * A shared base interface for all Blueprint component props.
 */
external interface IProps : PropsWithClassName {
    // redeclared here because re-defined in TS with this doc.
    /** A space-delimited list of class names to pass along to a child element. */
    override var className: ClassName?
}

external interface IntentProps {
    /** Visual intent color to apply to element. */
    var intent: Intent?
}

/**
 * Interface for a clickable action, such as a button or menu item.
 * These props can be spready directly to a `<Button>` or `<MenuItem>` element.
 */
external interface ActionProps : IntentProps, PropsWithClassName {
    /** Whether this action is non-interactive. */
    var disabled: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render before the text. */
    var icon: IconName? // IconName | MaybeElement

    /** Click event handler. */
    var onClick: MouseEventHandler<HTMLElement>?

    /** Action text. Can be any single React renderable. */
    var text: String?
}

/** Interface for a link, with support for customizing target window. */
external interface LinkProps {
    /** Link URL. */
    var href: String?

    /** Link target attribute. Use `"_blank"` to open in a new window. */
    var target: String?
}

/** Interface for a controlled input. */
@Deprecated("Use ControlledProps2", ReplaceWith("ControlledProps2"))
external interface IControlledProps {
    /** Initial value of the input, for uncontrolled usage. */
    var defaultValue: String?

    /** Change event handler. Use `event.target.value` for new value. */
    var onChange: FormEventHandler<HTMLElement>?

    /** Form value of the input, for controlled usage. */
    var value: String?
}

/** Interface for a controlled input. */
external interface ControlledProps2 {
    /** Initial value of the input, for uncontrolled usage. */
    var defaultValue: Any? // using Any? instead of String? to avoid conflict with react.dom.html.HTMLAttributes.defaultValue

    /** Form value of the input, for controlled usage. */
    var value: Any? // using Any? instead of String? to avoid conflict with react.dom.html.HTMLAttributes.defaultValue
}

external interface IElementRefProps<E : HTMLElement> {
    /** A ref handler or a ref object that receives the native HTML element rendered by this component. */
    var elementRef: Ref<E>
}

/**
 * An interface for an option in a list, such as in a `<select>` or `RadioGroup`.
 * These props can be spread directly to an `<option>` or `<Radio>` element.
 */
external interface OptionProps : IProps {
    /** Whether this option is non-interactive. */
    var disabled: Boolean?

    /** Label text for this option. If omitted, `value` is used as the label. */
    var label: String?

    /** Value of this option (string or number). */
    var value: Any? // String | Number
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
