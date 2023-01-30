package blueprintjs.core

import react.*

val BpButton = Button::class.react
val BpButtonGroup = ButtonGroup::class.react
val BpCallout = Callout::class.react
val BpCard = Card::class.react
val BpDialog = Dialog::class.react
val BpDivider = Divider::class.react
val BpHTMLTable = HTMLTable::class.react
val BpIcon = Icon::class.react
val BpInputGroup = InputGroup::class.react
val BpNonIdealState = NonIdealState::class.react
val BpOverlay = Overlay::class.react
val BpPopover = Popover::class.react
val BpSpinner = Spinner::class.react
val BpTag = Tag::class.react
val BpText = Text::class.react

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

var IPopoverProps.contentElement: ReactElement<*>?
    get() = content.unsafeCast<ReactElement<*>>()
    set(value) {
        content = value
    }

var IPopoverProps.contentText: String?
    get() = content as String?
    set(value) {
        content = value
    }
