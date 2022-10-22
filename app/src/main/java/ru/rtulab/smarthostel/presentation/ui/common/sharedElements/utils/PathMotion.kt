package ru.rtulab.smarthostel.presentation.ui.common.sharedElements.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp

typealias PathMotion = (start: Offset, end: Offset, fraction: Float) -> Offset

typealias PathMotionFactory = () -> PathMotion

val LinearMotion: PathMotion = ::lerp

val LinearMotionFactory: PathMotionFactory = { LinearMotion }
