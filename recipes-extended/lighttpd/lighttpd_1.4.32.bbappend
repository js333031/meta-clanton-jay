FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://proxy.pac"

do_install_append() {
     install -m 644 ${WORKDIR}/proxy.pac ${D}/www/pages/
}

