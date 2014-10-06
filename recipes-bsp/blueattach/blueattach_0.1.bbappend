FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "ti-wifi-utils"

SYSTEMD_AUTO_ENABLE = "enable"

SYSTEMD_BT_RESET = "\
ExecStartPre=${sbindir}/rfkill block bluetooth\n\
ExecStartPre=${base_bindir}/sleep 1\n\
ExecStartPre=${sbindir}/rfkill unblock bluetooth\n\
"

do_install_append () {
    sed -i "s#ExecStart=#${SYSTEMD_BT_RESET}ExecStart=#" ${D}${systemd_unitdir}/system/blueattach.service
}
