DESCRIPTION = "The calibrator and other useful utilities for TI wireless \
solution based on wl12xx driver"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"

SRCREV = "1971f622534da197994b3af6b8a73d38c75f768e"
PV = "0.0+gitr${SRCPV}"

SRC_URI = " \
    git://github.com/TI-OpenLink/ti-utils.git \
    file://0001-Dynamically-allocate-the-nvs_path-for-plt_tx_bip.patch \
    file://${PN}.service \
"

inherit systemd

S = "${WORKDIR}/git"

CFLAGS += " -DCONFIG_LIBNL20 -I${STAGING_INCDIR}/libnl3"
export LIBS = "-lnl-3 -lnl-genl-3 -lm"

SYSTEMD_SERVICE_${PN} = "${PN}.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 calibrator ${D}${bindir}/
    install -d ${D}${systemd_unitdir}/system/
    install -m 0755 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/
    sed -i -e 's,@BASE_SBINDIR@,${base_sbindir},g' \
           -e 's,@BASE_BINDIR@,${base_bindir},g' \
           -e 's,@BASE_LIBDIR@,${base_libdir},g' \
           -e 's,@SYSCONFDIR@,${sysconfdir},g' \
           -e 's,@SBINDIR@,${sbindir},g' \
           -e 's,@BINDIR@,${bindir},g' \
           -e 's,@LIBDIR@,${libdir},g' \
           ${D}${systemd_unitdir}/system/${PN}.service
}
