#!/bin/bash

if [[ -z "$1" ]]; then 
   echo "First argument is not set. It must be destination";
else
   DST_DIR=$1;
fi

if [[ -z "$2" ]]; then
   echo "Second argument is not set. Continuing, assuming it is full";
   IMG_TYPE="full";
else
   IMG_TYPE=$2;
fi

SRC_DIR="`pwd`/tmp/deploy/images"

doCopy() {
	cp -r $SRC_DIR/boot $DST_DIR
		cp $SRC_DIR/bzImage $DST_DIR/
		cp $SRC_DIR/core-image-minimal-initramfs-clanton.cpio.gz $DST_DIR/
		cp $SRC_DIR/grub.efi $DST_DIR/
	case "$IMG_TYPE" in
		"full")
			cp $SRC_DIR/image-full-clanton.ext3 $DST_DIR/
			;;
		"medium")
			cp $SRC_DIR/image-medium-clanton.ext3 $DST_DIR/image-full-clanton.ext3
			;;
                "sdk")
			cp $SRC_DIR/image-sdk-clanton.ext3 $DST_DIR/image-full-clanton.ext3
			;;
		esac
}

if [ -d "$SRC_DIR" ]; then
  doCopy
else
  echo "Source dir '$SRC_DIR' does not exist";
fi
