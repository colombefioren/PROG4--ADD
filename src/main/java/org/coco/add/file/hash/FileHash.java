package org.coco.add.file.hash;

import org.coco.add.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
