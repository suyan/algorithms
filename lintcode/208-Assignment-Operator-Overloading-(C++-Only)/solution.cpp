class Solution {
public:
    char *m_pData;
    Solution() {
        this->m_pData = NULL;
    }
    Solution(char *pData) {
        this->m_pData = pData;
    }

    // Implement an assignment operator
    Solution operator=(const Solution &object) {
        if (this != &object) {
            char *new_pData = nullptr;
            if (object.m_pData != nullptr) {
                auto count = strlen(object.m_pData);
                new_pData = new char[count];
                copy(object.m_pData, object.m_pData + count, new_pData);
            }

            if (m_pData != nullptr) {
                delete[] m_pData;
            }

            m_pData = new_pData;
        }
        return *this;
    }
};
