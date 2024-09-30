#Nums:top#
#Nums:import#

# <nums> **= LP <rule> <NUM> <stuff> RP
class Nums(): #Nums:class#

    className = "Nums"
    ruleString = "<nums> **= LP <rule> <NUM> <stuff> RP"
    ruleList = None
    numList = None
    stuffList = None

    def __init__(ruleList, numList, stuffList):
        #Nums:init#
        self.ruleList = ruleList
        self.numList = numList
        self.stuffList = stuffList

#Nums#
