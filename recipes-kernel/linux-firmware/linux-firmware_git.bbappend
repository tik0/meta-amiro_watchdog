FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://wl127x-nvs.bin"

do_install_append() {
    install -m 0644 ${WORKDIR}/wl127x-nvs.bin ${D}/lib/firmware/ti-connectivity/
}
