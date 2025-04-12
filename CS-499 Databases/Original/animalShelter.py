#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jun  7 21:07:42 2024

@author: davidsummers_snhu
"""

from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    def __init__(self, USER, PASS):
        USER = 'aacuser'
        PASS = 'aacuser'
        HOST = 'nv-desktop-services.apporto.com'
        PORT = 30677
        DB = 'AAC'
        COL = 'animals'
        
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT))
        self.database = self.client['%s' % (DB)]
        self.collection = self.database['%s' % (COL)]
        print ("Connection Successful")

# C method in CRUD
    def create(self, data):
        if data is not None:
            self.database.amimals.insert_one(data)
            return True
        else:
            raise Exception("Nothing to save, because data parameter is empty")

# R method in Crud
    def read(self, searchData):
        if searchData is not None:
            data = self.database.animals.find(searchData, {"_id": False})
        else:
            data = self.database.animals.find( {}, {"_id": False})
        return data
        
 # U method in CRUD
    def update(self, searchData, updateData):
        if searchData is not None:
            result = self.database.animals.update_one(searchData, {"$set": updateData})
        else:
            return"{}"
        return result.raw_result
    
 # D method in CRUD
    def delete(self, deleteData):
        if deleteData is not None:
            result = self.database.animals.delete_one(deleteData)
        else:
            return "{}"
        return result.raw_result
