FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://wl127x-nvs.bin \
    file://TIInit_7.2.31.bts \
"

do_install_append() {
    install -m 0644 ${WORKDIR}/wl127x-nvs.bin ${D}/lib/firmware/ti-connectivity/
    install -m 0644 ${WORKDIR}/TIInit_7.2.31.bts ${D}/lib/firmware/ti-connectivity/
}
