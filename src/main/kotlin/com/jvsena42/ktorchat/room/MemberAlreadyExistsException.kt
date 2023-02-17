package com.jvsena42.ktorchat.room

class MemberAlreadyExistsException : Exception(
    "There is already a member with this username in the room"
)