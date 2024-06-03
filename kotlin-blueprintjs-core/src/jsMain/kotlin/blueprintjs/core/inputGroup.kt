@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.*
import react.dom.aria.*
import react.dom.events.*
import react.dom.html.*
import web.dom.*
import web.html.*
import web.http.*
import web.window.*

external interface InputGroupProps : InputHTMLAttributesWithoutControlledInputValueProps, ControlledValueProps<String, HTMLInputElement>, InputSharedProps {
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

    // 'type' is already in InputHTMLAttributesWithoutControlledInputValueProps with a more precise type,
    // and it's not supposed to be excluded by the Omit even in TS (maybe a TS mistake?)
}

external interface IInputGroupState : State {
    var leftElementWidth: Int?
    var rightElementWidth: Int?
}

external class InputGroup : AbstractPureComponent<InputGroupProps, IInputGroupState> {
    override fun render(): ReactElement<InputGroupProps>
}

external interface InputHTMLAttributesWithoutControlledInputValueProps : AriaAttributes, DOMAttributes<HTMLInputElement>,
    react.PropsWithStyle {

    // ****** HTMLAttributes<HTMLInputElement> ******

    // React-specific Attributes
    var defaultChecked: Boolean?
    // OMITTED
    // var defaultValue: Any? /* string | number | ReadonlyArray<string> */
    var suppressContentEditableWarning: Boolean?
    var suppressHydrationWarning: Boolean?

    // Standard HTML Attributes
    var accessKey: String?
    var autoFocus: Boolean?
    var contentEditable: Any? // Booleanish | "inherit"
    var contextMenu: String?
    var dir: String?
    var draggable: Boolean?
    var hidden: Boolean?
    var id: String?
    var lang: String?
    var nonce: String?
    var placeholder: String?
    var slot: String?
    var spellCheck: Boolean?
    override var style: react.CSSProperties?
    var tabIndex: Int?
    var title: String?
    var translate: Translate?

    // Unknown
    var radioGroup: String? // <command>, <menuitem>

    // WAI-ARIA
    var role: AriaRole?

    // RDFa Attributes
    var about: String?
    var content: String?
    var datatype: String?
    var inlist: Any?
    var prefix: String?
    var property: String?
    var rel: String?
    var resource: String?
    var rev: String?
    var `typeof`: String?
    var vocab: String?

    // Non-standard Attributes
    var autoCapitalize: String?
    var autoCorrect: String?
    var autoSave: String?
    var itemProp: String?
    var itemScope: Boolean?
    var itemType: String?
    var itemID: String?
    var itemRef: String?
    var results: String?
    var security: String?
    var unselectable: Unselectable?
// Living Standard
    /**
     * Hints at the type of data that might be entered by the user while editing the element or its contents
     * @see https://html.spec.whatwg.org/multipage/interaction.html#input-modalities:-the-inputmode-attribute
     */
    var inputMode: InputMode?

    /**
     * Specify that a standard HTML element should behave like a defined custom built-in element
     * @see https://html.spec.whatwg.org/multipage/custom-elements.html#attr-is
     */
    var `is`: String?

    // ****** InputHTMLAttributes<HTMLInputElement> ******

    var accept: String?
    var alt: String?
    var autoComplete: AutoComplete?
    var capture: Capture?
    var checked: Boolean?
    var crossOrigin: CrossOrigin?
    var disabled: Boolean?
    var enterKeyHint: EnterKeyHint?
    var form: String?
    var formAction: String? /* FormAction */
    var formEncType: String?
    var formMethod: String?
    var formNoValidate: Boolean?
    var formTarget: WindowName?
    var height: Double?
    var list: String?
    var max: Any? /* number | Date */
    var maxLength: Int?
    var min: Any? /* number | Date */
    var minLength: Int?
    var multiple: Boolean?
    var name: String?
    var pattern: String?
    // override var placeholder: String? // unnecessary because of merged interfaces
    var readOnly: Boolean?
    var required: Boolean?
    var size: Int?
    var src: String?
    var step: Double?
    var type: InputType?
    var width: Double?
    var onChange: ChangeEventHandler<HTMLInputElement>?
}
