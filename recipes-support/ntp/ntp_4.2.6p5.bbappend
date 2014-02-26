FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://ntpdate.default file://ntp.conf"

do_install_append() {
     install -m 644 ${WORKDIR}/ntp.conf ${D}${sysconfdir}
     touch ${D}${sysconfdir}/foobar_sysconfdir.txt
     touch ${THISDIR}/foobar_thisdir.txt
     touch ${WORKDIR}/foobar_workdir.txt
}
