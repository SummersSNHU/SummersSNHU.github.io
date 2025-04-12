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

# Enhancement: create many
# create multiple entries
    def create_many(self, data_list: list[dict]) -> bool:
        if data_list and all(isinstance(doc, dict) for doc in data_list):
            self.database.animals.insert_many(data_list)
            return True
        else:
            raise Exception("Nothing to save, because data parameter is empty")

# R method in Crud
# displays entry
    def read(self, searchData):
        if searchData is not None:
            data = self.database.animals.find(searchData, {"_id": False})
        else:
            data = self.database.animals.find( {}, {"_id": False})
        return data
        
# U method in CRUD
# updates one entry
    def update(self, searchData, updateData):
        if not searchData or not updateData:
            raise ValueError("Both searchData and updateData must be provided")

        result = self.database.animals.update_one(searchData, {"$set": updateData})
        return result.raw_result

# Enhancement: update multiple
# updates multiple entries
    def update_many(self, searchData, updateData):
        if not searchData or not updateData:
            raise ValueError("Both searchData and updateData must be provided")

        result = self.database.animals.update_many(searchData, {"$set": updateData})
        return result.raw_result

    
# D method in CRUD
# deletes one entry
    def delete(self, deleteData):
        if deleteData is not None:
            result = self.database.animals.delete_one(deleteData)
        else:
            return "{}"
        return result.raw_result

# Enhancement: Delete multiple
# deletes multiple entries
    def delete_many(self, deleteData):
        if deleteData is not None:
             result = self.database.animals.delete_many(deleteData)
        else:
             return "{}"
         return result.raw_result

# Enhancement: Counts total entries
# Provides total number of entries in DB
    def count(self, filterData):
        if filterData is not None:
             count = self.database.animals.count_documents(filterData)
         else:
              return 0  # Return 0 if no filter is provided
          return count
