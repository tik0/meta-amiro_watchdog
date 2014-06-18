DESCRIPTION = "The calibrator and other useful utilities for TI wireless \
solution based on wl12xx driver"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"

SRCREV = "05dc3b63f0a710c83c89755ffdd9e9c5f8aab5c4"
PV = "0.0+gitr${SRCPV}"

SRC_URI = "git://github.com/TI-OpenLink/ti-utils.git"

S = "${WORKDIR}/git"

CFLAGS += " -DCONFIG_LIBNL20 -I${STAGING_INCDIR}/libnl3"
export LIBS = "-lnl-3 -lnl-genl-3 -lm"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 calibrator ${D}${bindir}/
}
