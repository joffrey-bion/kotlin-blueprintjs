package blueprintjs.core

import react.*

val BpButton = Button
val BpButtonGroup = ButtonGroup
val BpCallout = Callout::class.react
val BpCard = Card
val BpDialog = Dialog::class.react
val BpDialogBody = DialogBody::class.react
val BpDialogFooter = DialogFooter::class.react
val BpDivider = Divider::class.react
val BpHTMLTable = HTMLTable
val BpIcon = Icon
val BpInputGroup = InputGroup::class.react
val BpNonIdealState = NonIdealState::class.react
@Suppress("DEPRECATION")
@Deprecated(
    message = "use Overlay2 component instead",
    replaceWith = ReplaceWith("BpOverlay2", imports = ["blueprintjs.core.BpOverlay2"]),
)
val BpOverlay = Overlay::class.react
val BpOverlay2 = Overlay2
val BpPopover = Popover::class.js.unsafeCast<ComponentClass<PopoverProps<DefaultPopoverTargetHTMLProps>>>()
val BpSpinner = Spinner::class.react
val BpTag = Tag
val BpText = Text

var NonIdealStateProps.titleText: String?
    get() = title?.asStringOrNull()
    set(value) {
        title = value?.let { ReactNode(it) }
    }

var DialogProps.titleText: String?
    get() = title?.asStringOrNull()
    set(value) {
        title = value?.let { ReactNode(it) }
    }

var DialogProps.iconName: String?
    get() = throw IllegalArgumentException("iconName is a helper setter and should not ne used to access the value")
    set(value) {
        icon = value
    }

var PopoverProps<*>.contentElement: ReactElement<*>?
    get() = content.unsafeCast<ReactElement<*>>()
    set(value) {
        content = value
    }

var PopoverProps<*>.contentText: String?
    get() = content as String?
    set(value) {
        content = value
    }
