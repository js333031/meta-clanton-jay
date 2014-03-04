DESCRIPTION = "A fully functional image to be placed on SD card"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_INSTALL += "galileo-target"
IMAGE_INSTALL += "mtd-utils-jffs2"


IMAGE_LINGUAS = " "

LICENSE = "GPLv2"

IMAGE_FSTYPES = "ext3 live"

inherit core-image

NOISO = "1"
NOHDD = "1"
# see if new image fits in 30 MB
IMAGE_ROOTFS_SIZE = "30720"

EXTRA_IMAGECMD_append_ext2 = " -N 2000"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "kernel-modules"
IMAGE_INSTALL += "ethtool pciutils"
IMAGE_INSTALL += "strace"
IMAGE_INSTALL += "linuxptp"

IMAGE_INSTALL += "nodejs"
IMAGE_INSTALL += "wireless-tools wpa-supplicant bluez4"
IMAGE_INSTALL += "ppp openssh"

IMAGE_INSTALL += "linux-firmware-iwlwifi-6000g2a-6"
IMAGE_INSTALL += "linux-firmware-iwlwifi-135-6"

IMAGE_INSTALL += "e2fsprogs-mke2fs e2fsprogs-e2fsck dosfstools util-linux-mkfs"

IMAGE_INSTALL += "tor ntp-tickadj ntp ntpdate ntp-utils lighttpd "
EXTRA_IMAGEDEPENDS = "grub-conf"

ROOTFS_POSTPROCESS_COMMAND += "install_sketch ; "

install_sketch() {
        install -d ${IMAGE_ROOTFS}/sketch
}
