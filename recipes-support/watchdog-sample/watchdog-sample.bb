DESCRIPTION = "Watchdog sample daemon"

FILESEXTRAPATHS_prepend := "${THISDIR}/watchdog-sample/:"

SRC_URI += "file://watchdog-sample.service"

SYSTEMD_SERVICE_${PN} = "watchdog-sample.service"

RDEPENDS_${PN} = "systemd"
DEPENDS = "systemd"

S = "${WORKDIR}"

do_install() {
  # install service file
  install -d ${D}${systemd_unitdir}/system
  install -c -m 0644 ${WORKDIR}/watchdog-sample.service ${D}${systemd_unitdir}/system

  # enable the service
  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
  ln -sf ${systemd_unitdir}/system/watchdog-sample.service \
    ${D}${sysconfdir}/systemd/system/multi-user.target.wants/watchdog-sample.service
}

FILES_${PN} = "${base_libdir}/systemd/system/watchdog-sample.service"
FILES_${PN} += "${sysconfdir}/systemd/system/multi-user.target.wants/watchdog-sample.service"
FILES_${PN} += "${bindir}/watchdog-sample"


