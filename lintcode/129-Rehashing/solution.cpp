/**
 * Definition of ListNode
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *         this->val = val;
 *         this->next = NULL;
 *     }
 * }
 */
class Solution {
public:
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    vector<ListNode*> rehashing(vector<ListNode*> hashTable) {
        // double table size
        int old_size = hashTable.size();
        for (int i = 0; i < old_size; i++) {
            hashTable.push_back(nullptr);
        }
        
        // rehashing
        int new_size = old_size * 2;
        for (int i = 0; i < old_size; i++) {
            if (hashTable[i] == nullptr) {
                continue;
            }
            
            // the first node might be changed
            ListNode dummy(0);
            dummy.next = hashTable[i];
            ListNode *prev = &dummy;
            while (prev->next != nullptr) {
                int new_index = hashKey(prev->next->val, new_size);
                if (new_index != i) {
                    // move current node to new one
                    if (hashTable[new_index] == nullptr) {
                        hashTable[new_index] = prev->next;
                        prev->next = prev->next->next;
                        hashTable[new_index]->next = nullptr;
                    } else {
                        ListNode *tail = hashTable[new_index];
                        while (tail->next != nullptr) {
                            tail = tail->next;
                        }
                        tail->next = prev->next;
                        prev->next = prev->next->next;
                        tail->next->next = nullptr;
                    }
                } else {
                    prev = prev->next;
                }
            }
            hashTable[i] = dummy.next;
        }
        
        return hashTable;
    }
private:
    int hashKey(int key, int table_size) {
        return (key % table_size + table_size) % table_size;
    }
};